package sedatdilmac.com.orkunyonetim.pojo;

import lombok.Data;

/**
 * Created by SD
 * on 13.01.2019.
 */
@Data
public class Demo {

    private String url;
    private String name;
    private String amount;
    private boolean isPayed;

    public Demo(String url, String name, String amount, boolean isPayed) {
        this.url = url;
        this.name = name;
        this.amount = amount;
        this.isPayed = isPayed;
    }

}
