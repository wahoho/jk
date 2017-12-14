package com.forcas.jojo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

/**
 * Created by jason on 17/09/16.
 */
@SpringBootApplication
@EnableConfigurationProperties
open class JojoApplication {

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            runWebflux(JojoApplication::class)
        }
    }

    @Component
    open class CorsFilter : WebFilter {
        override fun filter(ctx: ServerWebExchange?, chain: WebFilterChain?): Mono<Void> {
            if (ctx != null) {
                ctx.response.headers.add("Access-Control-Allow-Origin", "*")
                ctx.response.headers.add("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS")
                ctx.response.headers.add("Access-Control-Allow-Headers", "DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Content-Range,Range")
                if (ctx.request.method == HttpMethod.OPTIONS) {
                    ctx.response.headers.add("Access-Control-Max-Age", "1728000")
                    ctx.response.statusCode = HttpStatus.NO_CONTENT
                    return Mono.empty()
                } else {
                    ctx.response.headers.add("Access-Control-Expose-Headers", "DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Content-Range,Range")
                    return chain?.filter(ctx) ?: Mono.empty()
                }
            } else {
                return chain?.filter(ctx) ?: Mono.empty()
            }
        }
    }
}

@Component
@ConfigurationProperties(prefix = "forcas.endpoint")
open class SystemConfiguration() {
    constructor(analysis: String, scoreLoaderApi: String): this() {
        this.analysis = analysis
        this.scoreLoaderApi = scoreLoaderApi
    }

    lateinit var analysis: String
    lateinit var scoreLoaderApi: String
}