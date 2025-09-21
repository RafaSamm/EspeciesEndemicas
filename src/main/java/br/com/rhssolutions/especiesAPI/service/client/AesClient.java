package br.com.rhssolutions.especiesAPI.service.client;

import br.com.rhssolutions.especiesAPI.dto.EspecieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "aesClient", url = "https://aes.shenlu.me/api/v1/")
public interface AesClient {

    @GetMapping("/species")
    List<EspecieDTO> getAllEspecies();

    @GetMapping("/random")
    EspecieDTO getRandomEspecie();

    @GetMapping("/country")
    List<String> getAllCountries();
}
