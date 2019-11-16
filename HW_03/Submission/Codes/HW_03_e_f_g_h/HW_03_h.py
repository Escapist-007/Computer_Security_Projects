
# coding: utf-8

# In[2]:


import hashlib
from Crypto.PublicKey import DSA
from Crypto.Signature import DSS
from timeit import default_timer


# In[3]:


start = default_timer ()
key = DSA.generate(3072)
end = default_timer()
print('2048 bit DSA key generation time in microsecond '+ str(end-start))


# # small file

# In[ ]:


sha256_hash = hashlib.sha256()

start = default_timer ()

with open("smallFile_1KB.txt","rb") as f:
    # Read and update hash string value in blocks of 4K
    for byte_block in iter(lambda: f.read(4096),b""):
        sha256_hash.update(byte_block)
    hash_obj = sha256_hash.hexdigest()
    
signer = DSS.new(key, 'fips-186-3')
signature = key.sign(hash_obj)

pub_key = key.publickey()

if pub_key.verify(hash_obj, signature):
    print "OK"
else:
    print "Incorrect signature"
    
end = default_timer ()

print('Using 2048 bit DSA key signing and verification time in microsecond '+ str(end-start))


# # large file

# In[ ]:


sha256_hash = hashlib.sha256()

start = default_timer()

with open("largeFile_1KB.txt","rb") as f:
    # Read and update hash string value in blocks of 4K
    for byte_block in iter(lambda: f.read(4096),b""):
        sha256_hash.update(byte_block)
    hash_obj = sha256_hash.hexdigest()
    
signer = DSS.new(key, 'fips-186-3')
signature = key.sign(hash_obj)

pub_key = key.publickey()

if pub_key.verify(hash_obj, signature):
    print "OK"
else:
    print "Incorrect signature"
    
end = default_timer ()

print('Using 2048 bit DSA key signing and verification time in microsecond '+ str(end-start))

