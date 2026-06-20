public class ExcelDocumentFactory extends DocumentFactory{
    public Document createDocument(){
        System.out.println("Excel Document created!");
        return new ExcelDocument();
    }
}
