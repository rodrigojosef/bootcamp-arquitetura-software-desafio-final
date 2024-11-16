package br.com.rjfpinformatica.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

import br.com.rjfpinformatica.BootcampArquiteturaSoftwareDesafioFinalApplication;

public class ApplicationModularityUnitTest {

	ApplicationModules modules = ApplicationModules.of(BootcampArquiteturaSoftwareDesafioFinalApplication.class);

    @Test
    void verifiesModularStructure() {
        modules.verify();
    }

    @Test
    void createModuleDocumentation() {
        new Documenter(modules)
          .writeDocumentation()
          .writeIndividualModulesAsPlantUml();
    }

    @Test
    void createApplicationModuleModel() {
        modules.forEach(System.out::println);
    }
}