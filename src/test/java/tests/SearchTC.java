package tests;

import Base.Base_Page;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTC extends Base_Page {
    @Test
    public void search_testcase(){
        String[] order= {"5","6","10","11","15"};
        String[] productNum= {"3","9","18"};
        var search=h.searchForProduct();
        search.setSearchText("gif");
        search.clickSearchButton();
        search.selectFromOrderBy(order[4]);
        search.selectFromPageSize(productNum[2]);
        String result=search.getSearchBody();
        System.out.println(result);
        Assert.assertNotNull(result);
        Assert.assertTrue(StringUtils.containsIgnoreCase(result, "gif"));    }
}
