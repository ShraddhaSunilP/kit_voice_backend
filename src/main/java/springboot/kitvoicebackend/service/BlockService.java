package springboot.kitvoicebackend.service;

import java.util.List;
import java.util.Optional;

import springboot.kitvoicebackend.entities.Block;

public interface BlockService {

	Block addBlock(Block block);

	List<Block> getAllBlock();

	Optional<Block> getBlockById(int block_id);

	Block updateBlock(int block_id, Block block);

	boolean deleteBlock(int block_id);

}
