package com.Hayykum.logic;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;

public class BlockChain {
    private List<Block> blocks = new ArrayList<>();
    private int difficulty = 2;
    private String lastHash = null;
    private static int blocksCount=1;

    public static int getBlocksCount() {
        return blocksCount;
    }

    public static void setBlocksCount(int blocksCount) {
        BlockChain.blocksCount = blocksCount;
    }

    public BlockChain() {
        
    }

    public BlockChain(List<Block> blocks, int difficulty) {
        this.blocks = blocks;
        this.difficulty = difficulty;
    }

    public void addBlock(Block block) {
        this.blocks.add(block);
        this.lastHash = block.getCurrentHash();
        blocksCount++;
    }

    public List<Block> blockExits(String patientNumber) {
        List<Block> blocks = new ArrayList<>();
        for (Block block : this.blocks) {
            if (block.getFields()[block.getFields().length-1].toString().equalsIgnoreCase(patientNumber)) {
                blocks.add(block);
            }
        }
        return blocks;
    }
    

    public boolean isChainValid() {
        if(this.blocks.size() == 0 || this.blocks.size() == 1) {
            return true;
        }
        for (int index = 0; index < this.blocks.size() - 1; index++) {
            if(isValidBlock(this.blocks.get(index), this.blocks.get(index + 1))) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

    private boolean isValidBlock(Block firstBlock, Block secondBlock) {
        if(firstBlock.getCurrentHash() == null || secondBlock.getCurrentHash() == null) {
            return false;
        }
        if(firstBlock.getPreviousHash() != null) {
            return false;
        }
        if(!firstBlock.getCurrentHash().equals(secondBlock.getPreviousHash())) {
            return false;
        }
        return true;
    }


    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getLastHash() {
        return lastHash;
    }

    public void setLastHash(String lastHash) {
        this.lastHash = lastHash;
    }
}

