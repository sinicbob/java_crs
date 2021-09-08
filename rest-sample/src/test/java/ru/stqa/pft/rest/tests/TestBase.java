package ru.stqa.pft.rest.tests;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;

import java.io.IOException;

public class TestBase {

  public boolean isIssueOpen(int issueId) throws IOException {
    String json = getExecutor().execute(Request.Get("https://bugify.stqa.ru/api/issues/" + issueId +".json"))
            .returnContent().asString();
      JsonElement parsed = new JsonParser().parse(json);
      JsonElement issueInfo = parsed.getAsJsonObject().get("issues").getAsJsonArray().get(0);
      String  state_name = issueInfo.getAsJsonObject().get("state_name").getAsString();
    if(state_name.equals("Resolved") || state_name.equals("Deleted") || state_name.equals("Closed")){
        return false;
      }else {
        return true;
      }
  }

  public Executor getExecutor() {
    return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490","");
  }

  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

}
