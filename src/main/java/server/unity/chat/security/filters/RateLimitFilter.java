package server.unity.chat.security.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RateLimitFilter extends OncePerRequestFilter {


    private final static byte requestsLimit = 10;
    private final static int timeStamp = 10_000;
    private final RateLimiter rateLimiter;

    public RateLimitFilter() {
        rateLimiter = new RateLimiter();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (rateLimiter.tryAcquire(timeStamp, requestsLimit)) {
            // Если Rate Limiter разрешает выполнение запроса, продолжайте цепочку фильтров
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(429);
            response.getWriter().write("Rate limit exceeded");
        }
    }


    private class RateLimiter{
        private int countOfRequests = 0;
        private Date lastCheck;


        public RateLimiter() {
            lastCheck = new Date();
        }

        public boolean tryAcquire(int timeStamp, byte requestsLimit){
            Date now = new Date();
            if(now.after(new Date(lastCheck.getTime()+timeStamp))){
                countOfRequests = 1;
                lastCheck = new Date();
            } else {
                return ++countOfRequests <= requestsLimit;
            }
            return true;

        }
    }
}
