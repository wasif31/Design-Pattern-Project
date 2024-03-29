package com.example.addmovie.CommentModel;



public class Articles
{
    private String publishedAt;

    private String author;

    private String urlToImage;

    private String description;

    private Source source;

    private String title;

    private String url;

    private String content;

    public String getPublishedAt ()
    {
        return publishedAt;
    }

    public void setPublishedAt (String publishedAt)
    {
        this.publishedAt = publishedAt;
    }

    public String getAuthor ()
    {
        return author;
    }

    public void setAuthor (String author)
    {
        this.author = author;
    }

    public String getUrlToImage ()
    {
        return urlToImage;
    }

    public void setUrlToImage (String urlToImage)
    {
        this.urlToImage = urlToImage;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public Source getSource ()
    {
        return source;
    }

    public void setSource (Source source)
    {
        this.source = source;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [publishedAt = "+publishedAt+", author = "+author+", urlToImage = "+urlToImage+", description = "+description+", source = "+source+", title = "+title+", url = "+url+", content = "+content+"]";
    }
}
