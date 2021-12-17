import java.net.URI
import java.net.URISyntaxException
import java.util.*
import java.util.regex.Pattern
import kotlin.collections.ArrayList

class TestTime {
    fun getUrlDomainName(url: String?): String {
        var domainName = url?:""
        var index: Int = domainName.indexOf("://")
        if (index != -1) {
            // keep everything after the "://"
            domainName = domainName.substring(index + 3)
        }
        index = domainName.indexOf('/')
        if (index != -1) {
            // keep everything before the '/'
            domainName = domainName.substring(0, index)
        }

        // check for and remove a preceding 'www'
        // followed by any sequence of characters (non-greedy)
        // followed by a '.'
        // from the beginning of the string
        domainName = domainName.replaceFirst("^www.*?\\.".toRegex(), "")
        val lastIndex = if(domainName.indexOf('.')>-1) domainName.indexOf('.') else domainName.length
        return domainName.substring(0, lastIndex).capitalize(Locale.ROOT)
    }


    inline fun <T, R>map(array: Array<T>, transform: (T)->R) : ArrayList<R>
    {
        val arr: ArrayList<R> = ArrayList()
        for (value in array){ arr.add(transform(value))}
        return arr
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

//        long time = 2640581L;
//        long days = TimeUnit.SECONDS.toDays(time);
//
//        long sec1 = TimeUnit.SECONDS.toSeconds(time) - (TimeUnit.SECONDS.toMinutes(time) * 60);
//        long sec= days*24*60*60;
//        if (time > sec1 && days < 30){
//            System.out.println("Hello");
//        }
//
//        try {
//            System.out.println(getHostName("bigbasket.com"));
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
            println(TestTime().getUrlDomainName("bigbasket.com"))
            println(TestTime().getUrlDomainName("bigbasket"))
            println(TestTime().getUrlDomainName("Unknown"))
            println(TestTime().getUrlDomainName("http://bigbasket.com"))
            println(TestTime().getUrlDomainName("http://www.bigbasket.com"))
            println(TestTime().getUrlDomainName("https://www.bigbasket.com"))
            println(TestTime().getUrlDomainName("https://bigbasket.com"))

        }

        @Throws(URISyntaxException::class)
        fun getHostName(url: String?): String? {
            val pattern = "(\\w*://)([\\w-_.]+)([:\\w\\W]*)"
            val r = Pattern.compile(pattern)
            val m = r.matcher(url)
            if (m.find()) {
                println(m.group(0))
                println(m.group(1))
                println(m.group(2))
                println(m.group(3))
            }
            val uri = URI(url)
            val hostname = uri.host
            // to provide faultproof result, check if not null then return only hostname, without www.
            return if (hostname != null) {
                if (hostname.startsWith("www.")) hostname.substring(4) else hostname
            } else hostname
        }
    }
}