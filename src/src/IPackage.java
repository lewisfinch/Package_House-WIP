public interface IPackage {
    void setStatus(int status);
    int getStatus();
    void setSize(int new_size);
    int getSize();
    void setOrderNumber(long orderNumber);
    long getOrderNumber();
    void setInfo(String information);
    String getInfo();
    void show();
}
