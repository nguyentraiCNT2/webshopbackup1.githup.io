package webmobileshop.repositorty;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webmobileshop.entity.GuestEntity;

@Repository
public interface GuestRepository extends JpaRepository<GuestEntity, String> {
	Optional<GuestEntity> findByQuestId(String questId);

	List<GuestEntity> findByquestName(String questName);

	List<GuestEntity> findByquestAddress(String questAddress);

	List<GuestEntity> findByquestEmail(String questEmail);

	List<GuestEntity> findByquestPhone(String questPhone);

	List<GuestEntity> findByfristName(String fristName);

	List<GuestEntity> findBylastName(String lastName);

	void deleteByQuestId(String questId);

	GuestEntity saveAndFlush(GuestEntity guestEntity);

}
