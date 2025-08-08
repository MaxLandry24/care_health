package cm.skysoft.Care_Health.Mapper;

import java.util.List;

public interface EntityMapper<D,E> {
    E toEntity(D dto);
    D toDto(E entity);
    List<D> fromEntities(List<E> entities);
    List<E> toEntities(List<D> entities);
}
