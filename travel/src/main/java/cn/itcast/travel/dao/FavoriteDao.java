package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;

public interface FavoriteDao
{
    /**
     * 根据rid和uid查询收藏对象
     * @param rid
     * @param uid
     * @return
     */
    public Favorite findByRidAndUid(int rid,int uid);

    int findCountByRid(int rid);

    void add(int rid, int uid);
}
