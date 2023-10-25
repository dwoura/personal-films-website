package com.ruoyi.system.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 电影资源管理对象 oss_movieinfo
 * 
 * @author ruoyi
 * @date 2023-01-05
 */
public class OssMovieinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 电影主键 */
    private Long movieId;

    /** 电影名称 */
    @Excel(name = "电影名称")
    private String movieName;

    /** 电影备注 */
    @Excel(name = "电影备注")
    private String movieRemark;

    /** 电影主演 */
    @Excel(name = "电影主演")
    private String movieActor;

    /** 电影导演 */
    @Excel(name = "电影导演")
    private String movieDirector;

    /** 电影海报 */
    @Excel(name = "电影海报")
    private String movieCover;

    /** 电影一级分类 */
    @Excel(name = "电影一级分类")
    private Long movieType1;

    /** 电影评分 */
    private String movieScore;

    /** 电影发行地区 */
    private String movieArea;

    /** 电影二级分类 */
    @Excel(name = "电影二级分类")
    private Long movieType2;

    /** 电影语言 */
    private String movieLan;

    /** 电影上映时间 */
    private String movieShowtime;

    /** 电影更新时间 */
    @Excel(name = "电影更新时间")
    private String movieUpdatetime;

    /** 电影简介 */
    private String movieContent;

    /** 电影播放列表1 */
    private String moviePlaylist1;

    /** 电影播放列表2 */
    private String moviePlaylist2;

    /** 备用字段1 */
    private String movieBak1;

    /** 备用字段2 */
    private String movieBak2;

    /** 备用字段3 */
    private String movieBak3;

    public void setMovieId(Long movieId) 
    {
        this.movieId = movieId;
    }

    public Long getMovieId() 
    {
        return movieId;
    }
    public void setMovieName(String movieName) 
    {
        this.movieName = movieName;
    }

    public String getMovieName() 
    {
        return movieName;
    }
    public void setMovieRemark(String movieRemark)
    {
        this.movieRemark = movieRemark;
    }

    public String getMovieRemark()
    {
        return movieRemark;
    }
    public void setMovieActor(String movieActor) 
    {
        this.movieActor = movieActor;
    }

    public String getMovieActor() 
    {
        return movieActor;
    }
    public void setMovieDirector(String movieDirector) 
    {
        this.movieDirector = movieDirector;
    }

    public String getMovieDirector() 
    {
        return movieDirector;
    }
    public void setMovieCover(String movieCover) 
    {
        this.movieCover = movieCover;
    }

    public String getMovieCover() 
    {
        return movieCover;
    }
    public void setMovieType1(Long movieType1) 
    {
        this.movieType1 = movieType1;
    }

    public Long getMovieType1() 
    {
        return movieType1;
    }
    public void setMovieScore(String movieScore) 
    {
        this.movieScore = movieScore;
    }

    public String getMovieScore() 
    {
        return movieScore;
    }
    public void setMovieArea(String movieArea) 
    {
        this.movieArea = movieArea;
    }

    public String getMovieArea() 
    {
        return movieArea;
    }
    public void setMovieType2(Long movieType2) 
    {
        this.movieType2 = movieType2;
    }

    public Long getMovieType2() 
    {
        return movieType2;
    }
    public void setMovieLan(String movieLan) 
    {
        this.movieLan = movieLan;
    }

    public String getMovieLan() 
    {
        return movieLan;
    }
    public void setMovieShowtime(String movieShowtime) 
    {
        this.movieShowtime = movieShowtime;
    }

    public String getMovieShowtime() 
    {
        return movieShowtime;
    }
    public void setMovieUpdatetime(String movieUpdatetime) 
    {
        this.movieUpdatetime = movieUpdatetime;
    }

    public String getMovieUpdatetime() 
    {
        return movieUpdatetime;
    }
    public void setMovieContent(String movieContent) 
    {
        this.movieContent = movieContent;
    }

    public String getMovieContent() 
    {
        return movieContent;
    }
    public void setMoviePlaylist1(String moviePlaylist1) 
    {
        this.moviePlaylist1 = moviePlaylist1;
    }

    public String getMoviePlaylist1() 
    {
        return moviePlaylist1;
    }
    public void setMoviePlaylist2(String moviePlaylist2) 
    {
        this.moviePlaylist2 = moviePlaylist2;
    }

    public String getMoviePlaylist2() 
    {
        return moviePlaylist2;
    }
    public void setMovieBak1(String movieBak1) 
    {
        this.movieBak1 = movieBak1;
    }

    public String getMovieBak1() 
    {
        return movieBak1;
    }
    public void setMovieBak2(String movieBak2) 
    {
        this.movieBak2 = movieBak2;
    }

    public String getMovieBak2() 
    {
        return movieBak2;
    }
    public void setMovieBak3(String movieBak3) 
    {
        this.movieBak3 = movieBak3;
    }

    public String getMovieBak3() 
    {
        return movieBak3;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("movieId", getMovieId())
            .append("movieName", getMovieName())
            .append("movieRemark", getMovieRemark())
            .append("movieActor", getMovieActor())
            .append("movieDirector", getMovieDirector())
            .append("movieCover", getMovieCover())
            .append("movieType1", getMovieType1())
            .append("movieScore", getMovieScore())
            .append("movieArea", getMovieArea())
            .append("movieType2", getMovieType2())
            .append("movieLan", getMovieLan())
            .append("movieShowtime", getMovieShowtime())
            .append("movieUpdatetime", getMovieUpdatetime())
            .append("movieContent", getMovieContent())
            .append("moviePlaylist1", getMoviePlaylist1())
            .append("moviePlaylist2", getMoviePlaylist2())
            .append("movieBak1", getMovieBak1())
            .append("movieBak2", getMovieBak2())
            .append("movieBak3", getMovieBak3())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
