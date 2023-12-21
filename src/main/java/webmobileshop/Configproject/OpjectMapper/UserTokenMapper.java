package webmobileshop.Configproject.OpjectMapper;

import org.modelmapper.ModelMapper;
import webmobileshop.dto.UserTokenDTO;
import webmobileshop.entity.UserTokenEntity;

public class UserTokenMapper {
    private final ModelMapper modelMapper;

    public UserTokenMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

   public UserTokenDTO  toDTO(UserTokenEntity entity){
       UserTokenDTO dto = new UserTokenDTO();
       dto.setUserTokenId(entity.getUserTokenId());
       dto.setReplaceToken(entity.getReplaceToken());
       dto.setExpiredtime(entity.getExpiredtime());
       dto.setMainToken(entity.getMainToken());
       dto.setUser(entity.getUser().getUserId());
       dto.setTime(entity.getTime());
       return dto;
   }

    public UserTokenEntity  toEntity(UserTokenDTO dto){
        UserTokenEntity entity = new UserTokenEntity();
        entity.setUserTokenId(dto.getUserTokenId());
        entity.setReplaceToken(dto.getReplaceToken());
        entity.setExpiredtime(dto.getExpiredtime());
        entity.setMainToken(dto.getMainToken());
        entity.setTime(dto.getTime());
        return entity;
    }
}
