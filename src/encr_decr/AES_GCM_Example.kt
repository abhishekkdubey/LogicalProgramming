package encr_decr

import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec


class AES_GCM_Example {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
    }
}


class Solution {

    val AES_KEY_SIZE = 256
    val GCM_IV_LENGTH = 12
    val GCM_TAG_LENGTH = 16
    val key: SecretKey by lazy {
        val keyGen = KeyGenerator.getInstance("AES")
        keyGen.init(AES_KEY_SIZE)
        keyGen.generateKey()
    }


    init {
        val keyGenerator = KeyGenerator.getInstance("AES")
        keyGenerator.init(AES_KEY_SIZE)

        // Generate Key

        // Generate Key
        val key = keyGenerator.generateKey()
        val IV = ByteArray(GCM_IV_LENGTH)
        val random = SecureRandom()
        random.nextBytes(IV)
    }


    @Throws(Exception::class)
    fun encrypt(
        string: String, key: SecretKey, IV: ByteArray?
    ): ByteArray? {

        val plaintext = string.toByteArray()
        // Get Cipher Instance
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")

        // Create SecretKeySpec
        val keySpec = SecretKeySpec(key.encoded, "AES")

        // Create GCMParameterSpec
        val gcmParameterSpec = GCMParameterSpec(GCM_TAG_LENGTH * 8, IV)

        // Initialize Cipher for ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec)

        // Perform Encryption
        return cipher.doFinal(plaintext)
    }

    @Throws(Exception::class)
    fun decrypt(cipherText: ByteArray?, key: SecretKey, IV: ByteArray?): String? {
        // Get Cipher Instance
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")

        // Create SecretKeySpec
        val keySpec = SecretKeySpec(key.encoded, "AES")

        // Create GCMParameterSpec
        val gcmParameterSpec = GCMParameterSpec(GCM_TAG_LENGTH * 8, IV)

        // Initialize Cipher for DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec)

        // Perform Decryption
        val decryptedText = cipher.doFinal(cipherText)
        return String(decryptedText)
    }
}