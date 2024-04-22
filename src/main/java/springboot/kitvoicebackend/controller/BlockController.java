package springboot.kitvoicebackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.kitvoicebackend.entities.Block;
import springboot.kitvoicebackend.service.BlockService;

@RestController
@RequestMapping("/block")
public class BlockController {
	
	@Autowired
	BlockService blockService;
	
	//add block
	@PostMapping("/addBlock")
	public Block addBlock(@RequestBody Block block) {
		return blockService.addBlock(block);
	}
	
	// get all block
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllBlock(){
		List<Block> block = blockService.getAllBlock();
		if(!block.isEmpty()) {
			return ResponseEntity.ok(block);
		} else {
			String errMsg = "No Records Found";
			return new ResponseEntity<>(errMsg,HttpStatus.NOT_FOUND);
		}
	}
	
	//get block by id
	@GetMapping("/{block_id}")
	public ResponseEntity<?> getBlockById(@PathVariable int block_id){
		Optional<Block> blk = blockService.getBlockById(block_id);
			if(blk.isPresent()) {
				return ResponseEntity.ok(blk.get());
			} else {
				String errMsg ="Block with ID "+block_id+" is not found";
				return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND);
			}
	}
	
	//update block by id
	@PutMapping("/{block_id}")
	public Block updateBlock(@PathVariable int block_id, @RequestBody Block block) {
		return blockService.updateBlock(block_id,block);
	}
	
	//delete block by id
	@DeleteMapping("/{block_id}")
	public  ResponseEntity<?> deleteBlock(@PathVariable int block_id){
		boolean isdeleted = blockService.deleteBlock(block_id);
		if(isdeleted) {
			String successMsg = "Block with ID " + block_id + " is deleted.";
			return ResponseEntity.ok(successMsg);
		} else {
			String errMsg = "Block with ID " + block_id + " is not found.";
			return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND);
		}
	}

}



