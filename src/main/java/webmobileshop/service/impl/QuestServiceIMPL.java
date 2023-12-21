package webmobileshop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmobileshop.Configproject.OpjectMapper.GuestMapper;
import webmobileshop.dto.GuestDTO;
import webmobileshop.entity.GuestEntity;
import webmobileshop.repositorty.GuestRepository;
import webmobileshop.service.GuestService;

@Service
public class QuestServiceIMPL implements GuestService  {
	
	@Autowired
	private GuestMapper guestMapper;
	private GuestRepository guestRepository;
	private ModelMapper modelMapper;

	
	
	public QuestServiceIMPL(GuestMapper guestMapper, GuestRepository guestRepository, ModelMapper modelMapper) {
		super();
		this.guestMapper = guestMapper;
		this.guestRepository = guestRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<GuestDTO> getAllGuest() {
		List<GuestEntity> quest = guestRepository.findAll();
		return quest.stream().map(quests ->guestMapper.toDTO(quests)).collect(Collectors.toList());
			
	}

	@Override
	public GuestDTO getByQuestId(String questId) {
		GuestEntity quest = guestRepository.findByQuestId(questId)
				.orElseThrow(() -> new RuntimeException("Không tìm thấy Khách hàng "));
		return modelMapper.map(quest, GuestDTO.class);
	}

	@Override
	public List<GuestDTO> getByquestName(String questName) {
		List<GuestEntity> quest = guestRepository.findByquestName(questName);
		return quest.stream().map(quests -> modelMapper.map(quests, GuestDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<GuestDTO> getByquestAddress(String questAddress) {
		List<GuestEntity> quest = guestRepository.findByquestAddress(questAddress);
		return quest.stream().map(quests -> modelMapper.map(quests, GuestDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<GuestDTO> getByquestEmail(String questEmail) {
		List<GuestEntity> quest = guestRepository.findByquestEmail(questEmail);
		return quest.stream().map(quests -> modelMapper.map(quests, GuestDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<GuestDTO> getByquestPhone(String questPhone) {
		List<GuestEntity> quest = guestRepository.findByquestPhone(questPhone);
		return quest.stream().map(quests -> modelMapper.map(quests, GuestDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<GuestDTO> getByfistName(String fristName) {
		List<GuestEntity> quest = guestRepository.findByfristName(fristName);
		return quest.stream().map(quests -> modelMapper.map(quests, GuestDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<GuestDTO> getBylastName(String lastName) {
		List<GuestEntity> quest = guestRepository.findBylastName(lastName);
		return quest.stream().map(quests -> modelMapper.map(quests, GuestDTO.class)).collect(Collectors.toList());
	}

	@Override
	public void createGuest(GuestDTO guestDTO) {
		if (guestDTO != null) {
			GuestEntity guests = guestMapper.toEntity(guestDTO);
			if (guests != null) {
				guestRepository.save(guests);
			}
		}
	}

	@Override
	public void updateGuest(GuestDTO guestDTO) {
		GuestEntity existingImages = guestRepository.findByQuestId(guestDTO.getQuestId())
				.orElseThrow(() -> new RuntimeException("Không tìm thấy Khách hàng"));
		modelMapper.map(guestDTO, existingImages);
		guestRepository.save(existingImages);
	}

	@Override
	public void deleteGuest(String questId) {
		guestRepository.deleteByQuestId(questId);
		
	}



}
