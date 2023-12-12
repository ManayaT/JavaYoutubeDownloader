import java.util.ArrayList;

public class ItagMovieList {
    /** 動画に関するitagのListを返す
     *
     */
    public ArrayList<String> getItagMovieList(String quality) {

        ArrayList<String> itagList = new ArrayList<>(); // itagList.add("");

        if (quality.equals("360p")) { //360p

            itagList.add("18");
            itagList.add("34");
            itagList.add("43");
            itagList.add("82");
            itagList.add("93");
            itagList.add("100");

            return itagList;
        } else if (quality.equals("480p")) { // 480p

            itagList.add("35");
            itagList.add("44");
            itagList.add("83");
            itagList.add("94");
            itagList.add("101");

            return itagList;
        } else { // 720p

            itagList.add("22");
            itagList.add("45");
            itagList.add("84");
            itagList.add("95");
            itagList.add("102");

            return itagList;
        }
    }
}
