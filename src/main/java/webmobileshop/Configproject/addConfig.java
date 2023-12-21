package webmobileshop.Configproject;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import webmobileshop.Configproject.OpjectMapper.*;

@Configuration
public class addConfig {

	 @Bean
	    public ModelMapper modelMapper() {
	        return new ModelMapper();
	    }

	    @Bean
	    public BlackListMapper blackListMapper(ModelMapper modelMapper,UserAccountMapper userAccountMapper) {
	        return new BlackListMapper(userAccountMapper, modelMapper);
	    }

	    @Bean
	    public CategoryItemMapper categoryItemMapper(ModelMapper modelMapper) {
	        return new CategoryItemMapper(modelMapper);
	    }

	    @Bean
	    public CategoryMapper categoryMapper(ModelMapper modelMapper) {
	        return new CategoryMapper(modelMapper);
	    }

	    @Bean
	    public ChatRoomMapper chatRoomMapper(ModelMapper modelMapper,ImagesMapper imagesMapper,UserAccountMapper userAccountMapper) {
	        return new ChatRoomMapper(imagesMapper, userAccountMapper, modelMapper);
	    }

	    @Bean
	    public CorlorMapper corlorMapper(ModelMapper modelMapper) {
	        return new CorlorMapper(modelMapper);
	    }

	    @Bean
	    public GuestMapper guestMapper(ModelMapper modelMapper) {
	        return new GuestMapper(modelMapper);
	    }

	    @Bean
	    public ImagesMapper imagesMapper(ModelMapper modelMapper) {
	        return new ImagesMapper(modelMapper);
	    }

	    @Bean
	    public ImportDetailMapper importDetailMapper(ModelMapper modelMapper,ImportMapper importMapper
	    		,ProductsMapper productsMapper,UserAccountMapper userAccountMapper) {
	        return new ImportDetailMapper(importMapper, productsMapper, userAccountMapper, modelMapper);
	    }

	    @Bean
	    public ImportMapper importMapper(ModelMapper modelMapper,CategoryMapper categoryMapper,CategoryItemMapper categoryItemMapper) {
	        return new ImportMapper(categoryMapper, categoryItemMapper, modelMapper);
	    }

	    @Bean
	    public LoveListMapper loveListMapper(ModelMapper modelMapper,UserAccountMapper userAccountMapper,ProductsMapper productsMapper) {
	        return new LoveListMapper(userAccountMapper, productsMapper, modelMapper);
	    }

	    @Bean
	    public MessageMapper messageMapper(ModelMapper modelMapper,UserAccountMapper userAccountMapper,ChatRoomMapper chatRoomMapper) {
	        return new MessageMapper(userAccountMapper, chatRoomMapper, modelMapper);
	    }

	    @Bean
	    public OrderDetailMapper orderDetailMapper(ModelMapper modelMapper,ProductsMapper productsMapper
	    		,OrderMapper orderMapper,UserAccountMapper userAccountMapper) {
	        return new OrderDetailMapper(orderMapper, productsMapper, userAccountMapper, modelMapper);
	    }

	    @Bean
	    public OrderMapper orderMapper(ModelMapper modelMapper,UserAccountMapper userAccountMapper,ProductsMapper productsMapper
	    		,GuestMapper guestMapper) {
	        return new OrderMapper(productsMapper, userAccountMapper, guestMapper, modelMapper);
	    }

	    @Bean
	    public ProductsMapper productsMapper(ModelMapper modelMapper,ImagesMapper imagesMapper,VideoMaper videoMapper
	    		,CategoryItemMapper categoryItemMapper,CategoryMapper categoryMapper,CorlorMapper colorMapper,SizeMapper sizeMapper) {
	        return new ProductsMapper(imagesMapper, videoMapper, categoryItemMapper, categoryMapper, colorMapper, sizeMapper, modelMapper);
	    }

	    @Bean
	    public ReviewMapper reviewMapper(ModelMapper modelMapper) {
	        return new ReviewMapper(modelMapper);
	    }

	    @Bean
	    public RoleMapper roleMapper(ModelMapper modelMapper) {
	        return new RoleMapper(modelMapper);
	    }

	    @Bean
	    public ShoppingCartMapper shoppingCartMapper(ModelMapper modelMapper) {
	        return new ShoppingCartMapper(modelMapper);
	    }

	    @Bean
	    public SizeMapper sizeMapper(ModelMapper modelMapper) {
	        return new SizeMapper(modelMapper);
	    }

	    @Bean
	    public UserAccountMapper userAccountMapper(ModelMapper modelMapper) {
	        return new UserAccountMapper( modelMapper);
	    }

	    @Bean
	    public VideoMaper videoMapper(ModelMapper modelMapper) {
	        return new VideoMaper(modelMapper);
	    }
		@Bean
		public UserTokenMapper userTokenMapper(ModelMapper modelMapper) {
		return new UserTokenMapper(modelMapper);
	}
}
