public class PdfDocumentFactory extends DocumentFactory{
    public Document createDocument(){
        System.out.println("Pdf Document created!");
        return new PdfDocument();
    }
}
