public class ExcelExportFactory implements ExportFactory {
    @Override
    public Export createExport() {
        return new ExcelExport();
    }
}
