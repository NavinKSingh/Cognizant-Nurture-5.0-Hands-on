public class Main {
    public static void main(String[] args) {
        DocumentFactory factory1 = new WordDocumentFactory();
        Document d1 = factory1.createDocument();
        d1.open();

        DocumentFactory factory2 = new PdfDocumentFactory();
        Document d2 = factory2.createDocument();
        d2.open();

        DocumentFactory factory3 = new ExcelDocumentFactory();
        Document d3 = factory3.createDocument();
        d3.open();
    }
}