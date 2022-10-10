public interface ILocker {
    int insert(long orderNum);
    void unlock(int code);
    void show();
}
