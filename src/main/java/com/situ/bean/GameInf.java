package com.situ.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class GameInf {
    private Integer gid;
    private String gno;
    private  String gameName;
    private String gameType;
    private  String status;
    private String cid;
    @JsonFormat(pattern = "yyyy年MM月dd日" ,timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy年MM月dd日")
    private Date releaseDate;
    private BigDecimal price;

    @Override
    public String toString() {
        return "GameInf{" +
                "gid=" + gid +
                ", gno='" + gno + '\'' +
                ", gameName='" + gameName + '\'' +
                ", gameType='" + gameType + '\'' +
                ", status='" + status + '\'' +
                ", cid='" + cid + '\'' +
                ", releaseDate=" + releaseDate +
                ", price=" + price +
                '}';
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGno() {
        return gno;
    }

    public void setGno(String gno) {
        this.gno = gno;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getcid() {
        return cid;
    }

    public void setcid(String cid) {
        this.cid = cid;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public GameInf() {
    }

    public GameInf(Integer gid, String gno, String gameName, String gameType, String status, String cid, Date releaseDate, BigDecimal price) {
        this.gid = gid;
        this.gno = gno;
        this.gameName = gameName;
        this.gameType = gameType;
        this.status = status;
        this.cid = cid;
        this.releaseDate = releaseDate;
        this.price = price;
    }


}
