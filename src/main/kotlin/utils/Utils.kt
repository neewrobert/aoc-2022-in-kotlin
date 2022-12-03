import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

private const val BASE_PATH = "src/main/resources/"


/**
 * Reads the entire content of the given input txt file as a String.
 */
fun readInputText(name: String, year: String) = getFileFrom(name, year).readText()

/**
 * Reads lines from the given input txt file.
 */
fun readInputLines(year: String, name: String) = getFileFrom(name, year).readLines()

/**
 * Gets a File from year and name
 */
fun getFileFrom(name: String, year: String) = File(BASE_PATH + year, "$name.txt")

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')
