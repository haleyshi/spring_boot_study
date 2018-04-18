package com.sgh.oidcdemo.controllers;

//import java.security.Principal;
import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

//@RestController
@Controller
public class MyController {
	private final OAuth2AuthorizedClientService authorizedClientService;

	public MyController(OAuth2AuthorizedClientService authorizedClientService) {
		this.authorizedClientService = authorizedClientService;
	}

	//@GetMapping("/")
	// public String index(Principal user) {
	// return "Hello " + user.getName();
	// }
	@RequestMapping("/")
	public String index(Model model, OAuth2AuthenticationToken token) {
		OAuth2AuthorizedClient authorizedClient = this.getAuthorizedClient(token);
		model.addAttribute("userName", token.getName());
		model.addAttribute("clientName", authorizedClient.getClientRegistration().getClientName());
		return "index";
	}

	@RequestMapping("/userinfo")
	public String userinfo(Model model, OAuth2AuthenticationToken token) {
		OAuth2AuthorizedClient authorizedClient = this.getAuthorizedClient(token);
		Map userAttributes = Collections.emptyMap();
		String userInfoEndpointUri = authorizedClient.getClientRegistration().getProviderDetails().getUserInfoEndpoint()
				.getUri();
		if (!StringUtils.isEmpty(userInfoEndpointUri)) {
			userAttributes = WebClient.builder().filter(oauth2Credentials(authorizedClient)).build().get()
					.uri(userInfoEndpointUri).retrieve().bodyToMono(Map.class).block();
		}
		model.addAttribute("userAttributes", userAttributes);
		return "userinfo";
	}

	private OAuth2AuthorizedClient getAuthorizedClient(OAuth2AuthenticationToken token) {
		return this.authorizedClientService.loadAuthorizedClient(token.getAuthorizedClientRegistrationId(),
				token.getName());
	}

	private ExchangeFilterFunction oauth2Credentials(OAuth2AuthorizedClient authorizedClient) {
		return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
			ClientRequest authorizedRequest = ClientRequest.from(clientRequest)
					.header(HttpHeaders.AUTHORIZATION, "Bearer " + authorizedClient.getAccessToken().getTokenValue())
					.build();
			return Mono.just(authorizedRequest);
		});
	}

}
