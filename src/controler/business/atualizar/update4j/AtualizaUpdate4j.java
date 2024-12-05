package controler.business.atualizar.update4j;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.update4j.Archive;
import org.update4j.Configuration;
import org.update4j.UpdateOptions;
import org.update4j.UpdateOptions.ArchiveUpdateOptions;

import controler.interfaces.IAtualiza;

public class AtualizaUpdate4j implements IAtualiza
{
    private Configuration config;

    public AtualizaUpdate4j(Configuration config)
    {
        this.config = config;
    }

    @Override
    public void atualiza() 
    {
        Path zip = Paths.get("print-update.zip");
        ArchiveUpdateOptions arqv;
        
        try 
        {
            arqv = UpdateOptions.archive(zip);

            Archive.read(zip).install();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
		}
    }

    @Override
    public boolean temAtualizacao()  
    {
        try 
        {
            return config.requiresUpdate();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        return false;
    }
}