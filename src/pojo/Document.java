package pojo;

public class Document {
    private static final int UNKNOWN = 0;
    private static final int DOC = 1;
    private static final int DOCX = 2;
    private static final int XLS = 3;
    private static final int XLSX = 4;
    private static final int PPT = 5;
    private static final int PPTX = 6;

    public static final int PRINT_BLACK = 1;
    public static final int PRINT_COLOR = 2;

    private int id;
    private String name;
    private int format = UNKNOWN;
    private int pages;
    private Customer customer;
    private String path;
    private double size;
    /**
     * 注意此处有改动，打印类型和打印份数作为文件的属性，可由用户设置
     * 默认为黑白和0份，选中打印改此属性为1份或多份，无需存入数据库
     * 这样订单中只需要有一个文件列表即可
     */
    private int printType = PRINT_BLACK;
    private int numberOfCopies = 0;
    private int orderId = 0;//订单id等于0说明此文件没有加入任何一个订单

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFormat() {

        return format;
    }

    public void setFormat(int type) {
        format = type;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public int getPrintType() {
        return printType;
    }

    public void setPrintType(int printType) {
        this.printType = printType;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
