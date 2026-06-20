public class WordDocumentFactory extends DocumentFactory{
    public Document createDocument(){
        System.out.println("Word Document created!");
        return new WordDocument();
    }
}
