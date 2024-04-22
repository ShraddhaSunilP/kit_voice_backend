package springboot.kitvoicebackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.kitvoicebackend.entities.Block;
import springboot.kitvoicebackend.repository.BlockRepository;

@Service
public class BlockServiceImpl implements BlockService {
	
	@Autowired
	BlockRepository blockRepository;

	@Override
	public Block addBlock(Block block) {
		 blockRepository.save(block);
		 return block;
	}

	@Override
	public List<Block> getAllBlock() {
		return blockRepository.findAll();
	}

	@Override
	public Optional<Block> getBlockById(int block_id) {
		return blockRepository.findById(block_id);
	}

	@Override
	public Block updateBlock(int block_id, Block block) {
		blockRepository.save(block);
		return block;
	}

	@Override
	public boolean deleteBlock(int block_id) {
		Optional<Block> block = blockRepository.findById(block_id);
		if(block.isPresent()) {
			blockRepository.deleteById(block_id);
			return true;
		} else {
			 return false;
		}
	}
}
