
package com.sistemajuridico;

import com.sistemajuridico.repository.DemandanteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemandanteRepositoryTest {

    @Autowired
    private DemandanteRepository demandanteRepository;

    @Test
    void consultarDemandantes() {
        var demandantes = demandanteRepository.findAll();

        var encontrados = demandanteRepository
                .findByNombreDemandanteContainingIgnoreCase("María");

        System.out.println("Cantidad encontrados con María: " + encontrados.size());

        encontrados.forEach(demandante ->
                System.out.println(demandante.getNombreDemandante())
        );

        System.out.println("Cantidad de demandantes: " + demandantes.size());

        demandantes.forEach(demandante ->
                System.out.println(demandante.getNombreDemandante())
        );

        assertTrue(!demandantes.isEmpty());
    }
}
