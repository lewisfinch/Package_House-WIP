public class Package implements IPackage {
    long orderNum;
    String info;
    int status;
    int size;

    public Package(){}

    public Package (long orderNumber, String information) {
        orderNum = orderNumber;
        info = information;
        status = 0;
        size = -1;
    }

    @Override
    public void setStatus(int new_status) {
        status = new_status;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public void setSize(int new_size) {
        size = new_size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setOrderNumber(long orderNumber) {
        orderNum = orderNumber;
    }

    @Override
    public long getOrderNumber() {
        return orderNum;
    }

    @Override
    public void setInfo(String information) {
        info = information;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void show() {
        System.out.println("{ * Package number: "+getOrderNumber()+"; Info: "+getInfo()+"; Status: "+getStatus()+" * }\n");
    }
}
