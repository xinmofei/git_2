package com.taobao.hsf.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.taobao.tsp.search.client.model.ResultModelSupport;
import com.taobao.tsp.search.client.model.article.ArticleSearchDTO;
import com.taobao.tsp.search.client.model.article.ArticleSearchModel;
import com.taobao.tsp.search.client.model.article.ArticleSearchResultModel;
import com.taobao.tsp.search.client.service.TspSearchArticleService;

/**
 * @author yijiang
 * @since 2011-11-29
 */
public class HelloWorldServlet extends HttpServlet {
    private static final long            serialVersionUID = 8882855019099459077L;

    private static WebApplicationContext context          = null;

    @SuppressWarnings("unchecked")
    @Override
    public void init() throws ServletException {
        super.init();
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TspSearchArticleService service = (TspSearchArticleService) context.getBean("tspSearchArticleService");
        ArticleSearchModel articleSearchModel = new ArticleSearchModel();
        articleSearchModel.setServiceType("31");

        ResultModelSupport<ArticleSearchResultModel<ArticleSearchDTO>> support = service.queryArticle(articleSearchModel);

        service.queryArticle(articleSearchModel);
        System.out.println(service);
    }
}
