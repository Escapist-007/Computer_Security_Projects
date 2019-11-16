
# coding: utf-8

# ### Create a 3072-bit RSA key

# In[1]:


from Crypto.PublicKey import RSA 
from timeit import default_timer


# In[2]:


start = default_timer ()
key = RSA.generate(3072)
end = default_timer ()
print('3072 bit key generation time in microsecond '+ str(end-start))

public_key_3072 =  key.publickey()
private_key_3072 = key


# ### Encryption using 3072 bit key

# ##### small file

# In[3]:


from Crypto.Cipher import PKCS1_OAEP


# In[4]:


cipher = PKCS1_OAEP.new(public_key_3072)

start = default_timer ()
with open("smallFile_1KB.txt", "rb") as in_file, open("smallFile_1KB_Enc.txt", "wb") as out_file:
    while True:
        piece = in_file.read(128)
        if len(piece)==0:
            break # end of file   
        out_file.write(cipher.encrypt(piece))
end = default_timer ()
print('Small file encryption time in microsecond using 3072 bit RSA  '+ str(end-start)) 


# ###### large file

# In[5]:


start = default_timer ()
with open("largeFile_1MB.txt", "rb") as in_file, open("largeFile_1MB_Enc.txt", "wb") as out_file:
    while True:
        piece = in_file.read(128)
        if len(piece)==0:
            break # end of file   
        out_file.write(cipher.encrypt(piece))
end = default_timer ()
print('Large file encryption time in microsecond using 3072 bit RSA  '+ str(end-start)) 


# ### Decryption using 3072 bit key

# ###### small file

# In[6]:


cipher = PKCS1_OAEP.new(private_key_3072)

start = default_timer ()
with open("smallFile_1KB_Enc.txt", "rb") as in_file, open("smallFile_1KB_Dec.txt", "wb") as out_file:
    while True:
        piece = in_file.read(384)  # 3072/8
        if len(piece)==0:
            break # end of file
        out_file.write(cipher.decrypt(piece))
end = default_timer ()
print('Small file decryption time in microsecond using 3072 bit RSA  '+ str(end-start))


# #### Large file

# In[7]:


start = default_timer ()
with open("largeFile_1MB_Enc.txt", "rb") as in_file, open("largeFile_1MB_Dec.txt", "wb") as out_file:
    while True:
        piece = in_file.read(384)
        if len(piece)==0:
            break # end of file
        out_file.write(cipher.decrypt(piece))
end = default_timer ()
print('Large file decryption time in microsecond using 3072 bit RSA  '+ str(end-start))

