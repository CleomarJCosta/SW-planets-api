package com.dev.SWplanetsapi.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.dev.SWplanetsapi.common.PlanetConstants.PLANET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

//@SpringBootTest(classes = PlanetService.class)
@ExtendWith(MockitoExtension.class)
public class PlanetServiceTest {
//    @Autowired
    @InjectMocks //cria uma instância dele e injeta todas as dependências com mocks
    private PlanetService planetService;
//    @MockBean
    @Mock
    private PlanetRepository planetRepository;

    //operação_estado_retorno
    @Test
    public void createPlanet_WithValidadData_ReturnsPlanet(){
        when(planetRepository.save(PLANET)).thenReturn(PLANET);

        //system under test -> alvo de teste
        Planet sut = planetService.create(PLANET);
        assertThat(sut).isEqualTo(PLANET);

    }
}
