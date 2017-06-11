package hello;

import io.swagger.annotations.ApiModelProperty;

public class Greeting {

	@ApiModelProperty(notes="Identity column",required=true)
    private final long id;
	@ApiModelProperty(notes="Actual Content to be displayed")
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
