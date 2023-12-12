import java.util.ArrayList;

public class ItagVideoList {
    /** 映像に関するitagのListを返す
     *
     */
    public ArrayList<String> getItagVideoList(String quality) {

        ArrayList<String> itagList = new ArrayList<>(); // itagList.add("");

        if (quality.equals("360p")) { //360p

            itagList.add("167");
            itagList.add("243");
            itagList.add("134");
            itagList.add("396");

            return itagList;
        } else if (quality.equals("480p")) { // 480p

            itagList.add("168");
            itagList.add("244");
            itagList.add("245");
            itagList.add("246");
            itagList.add("135");
            itagList.add("397");

            return itagList;
        } else if (quality.equals("720p")) { // 720p

            itagList.add("247");
            itagList.add("136");
            itagList.add("398");

            return itagList;
        } else if (quality.equals("720p60")) { // 720p60

            itagList.add("302");
            itagList.add("334");
            itagList.add("298");

            return itagList;
        } else if (quality.equals("1080p")) { // 1080p

            itagList.add("169");
            itagList.add("248");
            itagList.add("137");
            itagList.add("399");

            return itagList;
        } else { // 1080p60

            itagList.add("335");
            itagList.add("303");
            itagList.add("299");

            return itagList;
        }
    }
}
