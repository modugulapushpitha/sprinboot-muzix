package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class TrackController {
    private TrackService trackService;
    @Autowired
    public TrackController(TrackService trackService){
        this.trackService=trackService;
    }
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        ResponseEntity responseEntity;
        try{
            trackService.saveTrack(track);
            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (Exception ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks(){
        ResponseEntity responseEntity;
        try{
            trackService.getAllTracks();
            responseEntity= new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
        } catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable("id") int id){
        ResponseEntity responseEntity;
        try {
            trackService.getTrackById(id);
            responseEntity=new ResponseEntity<String>("track found", HttpStatus.OK);
        } catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
            return responseEntity;
    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<Track> deleteTrack(@PathVariable("id") int id) {
        ResponseEntity responseEntity;
        try {
            trackService.deleteTrackById(id);
            responseEntity = new ResponseEntity<String>("Track Deleted", HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PutMapping("track/{id}")
    public ResponseEntity<Track> UpdateTrack(@RequestBody Track track){
        ResponseEntity responseEntity;

        try {

            trackService.updateTrack(track);
            responseEntity= new ResponseEntity<String>("Track Updated", HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}

