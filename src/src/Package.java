public class Package implements IPackage {
    long orderNum;
    String info;

    public Package (long orderNumber, String information) {
        orderNum = orderNumber;
        info = information;
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
}
