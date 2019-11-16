
# coding: utf-8

# ### Create a 2048-bit RSA key

# In[1]:


from Crypto.PublicKey import RSA 
from timeit import default_timer


# In[2]:


start = default_timer ()
key = RSA.generate(2048)
end = default_timer ()
print('2048 bit RSA key generation time in microsecond '+ str(end-start))

public_key_2048 =  key.publickey()
private_key_2048 = key


# ### Encryption using 2048 bit key

# ##### small file

# In[3]:


from Crypto.Cipher import PKCS1_OAEP


# In[4]:


cipher = PKCS1_OAEP.new(public_key_2048)

start = default_timer ()
with open("smallFile_1KB.txt", "rb") as in_file, open("smallFile_1KB_Enc.txt", "wb") as out_file:
    while True:
        piece = in_file.read(128)
        if len(piece)==0:
            break # end of file   
        out_file.write(cipher.encrypt(piece))
end = default_timer ()
print('Small file encryption time in microsecond using 2048 bit RSA  '+ str(end-start)) 


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
print('Large file encryption time in microsecond using 2048 bit RSA  '+ str(end-start)) 


# ### Decryption using 2048 bit key

# ###### small file

# In[6]:


cipher = PKCS1_OAEP.new(private_key_2048)

start = default_timer ()
with open("smallFile_1KB_Enc.txt", "rb") as in_file, open("smallFile_1KB_Dec.txt", "wb") as out_file:
    while True:
        piece = in_file.read(256)
        if len(piece)==0:
            break # end of file
        out_file.write(cipher.decrypt(piece))
end = default_timer ()
print('Small file decryption time in microsecond using 2048 bit RSA  '+ str(end-start))


# #### Large file

# In[7]:


start = default_timer ()
with open("largeFile_1MB_Enc.txt", "rb") as in_file, open("largeFile_1MB_Dec.txt", "wb") as out_file:
    while True:
        piece = in_file.read(256)
        if len(piece)==0:
            break # end of file
        out_file.write(cipher.decrypt(piece))
end = default_timer ()
print('Large file decryption time in microsecond using 2048 bit RSA  '+ str(end-start))

