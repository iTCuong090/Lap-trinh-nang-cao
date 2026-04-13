public class PdfExportFactory implements ExportFactory {
    @Override
    public Export createExport() {
        return new PdfExport();
    }
}
