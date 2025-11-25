package adra.repository;

import java.io.IOException;

public class EnvioFileRepositoryAdapter extends BaseFileRepository
        implements EnvioRepository {

    public EnvioFileRepositoryAdapter(String filePath) {
        super(filePath);
    }

    @Override
    public void saveEnvio(String constanciaTexto) throws IOException {
        appendLine(constanciaTexto);
    }
}
