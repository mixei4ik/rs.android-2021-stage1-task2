package subtask2

class Abbreviation {


    fun abbreviationFromA(a: String, b: String): String {
        var aUpper = a.toUpperCase()
        var bClon = b

        while (onCheckFirstCharB(aUpper, bClon)) {
            aUpper = aUpper.substring(aUpper.indexOf(bClon[0]) + 1)
            bClon = bClon.drop(1)
            if (bClon.isEmpty()) return "YES"
        }
        return "NO"
    }

    fun onCheckFirstCharB(a: String, b: String): Boolean {
        for (char in a) {
            if (b[0] == char) {
                return true
            }
        }
        return false
    }
}
