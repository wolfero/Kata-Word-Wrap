public class WordWrapper {
    public String wrap(String text,int columnsWidth){
        if (text.length() == 0) return "";

        if (columnsWidth < 0) throw new IllegalArgumentException("Negative numbers are not allowed");

        return text;
    }
}
