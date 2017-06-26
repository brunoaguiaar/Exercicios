package repositorio;

import model.Video;

/**
 *
 * @author Bruno
 */
public class VideoDao extends GenericDao<Video, Long>{
    public VideoDao(EntityManager entityManager) {
        super(Video.class, entityManager);
    }
}
