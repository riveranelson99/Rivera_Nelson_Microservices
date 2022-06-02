package com.company.gamestoreinvoicing.util.feign;

import com.company.gamestoreinvoicing.viewModel.ConsoleViewModel;
import com.company.gamestoreinvoicing.viewModel.GameViewModel;
import com.company.gamestoreinvoicing.viewModel.TShirtViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "gamestore-catalog")
public interface CatalogService {

    @GetMapping("/console/{id}")
    public ConsoleViewModel getConsole(@PathVariable("id") long consoleId);

    @GetMapping("/game/{id}")
    public GameViewModel getGame(@PathVariable("id") long gameId);

    @GetMapping("/tshirt/{id}")
    public TShirtViewModel getTShirt(@PathVariable("id") long tShirtId);
}
