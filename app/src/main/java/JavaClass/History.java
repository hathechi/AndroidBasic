package JavaClass;

import java.io.Serializable;
import java.util.Date;
public class History implements Serializable {
    private int hinh;
    private int hinh2;
    private Date time;
    private String tendoan;
    private String ketqua;

    public History(int hinh, int hinh2, Date time, String tendoan, String ketqua) {
        this.hinh = hinh;
        this.hinh2 = hinh2;
        this.time = time;
        this.tendoan = tendoan;
        this.ketqua = ketqua;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public int getHinh2() {
        return hinh2;
    }

    public void setHinh2(int hinh2) {
        this.hinh2 = hinh2;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTendoan() {
        return tendoan;
    }

    public void setTendoan(String tendoan) {
        this.tendoan = tendoan;
    }

    public String getKetqua() {
        return ketqua;
    }

    public void setKetqua(String ketqua) {
        this.ketqua = ketqua;
    }
}
