package JavaClass;

import java.io.Serializable;
// Phải "implements Serializable" để gửi dữ liệu đi
public class InfoStudent  implements Serializable
{
    private String name;
    private int image;
    private String namsinh;
    private String gioitinh;

    public InfoStudent(String name, int image, String namsinh, String gioitinh) {
        this.name = name;
        this.image = image;
        this.namsinh = namsinh;
        this.gioitinh = gioitinh;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
}
