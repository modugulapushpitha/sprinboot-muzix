package com.stackroute.service;
import com.stackroute.domain.Track;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import com.stackroute.exception.TrackAlreadyExistException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceTest {
    Track track;
    @Mock
    TrackRepository trackRepository;
    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list= null;
    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setId(1);
        track.setName("believer");
        track.setComment("Imaginer");
        list = new ArrayList<>();
        list.add(track);

    }
  @Test
    public void saveTrackTestSuccess() throws TrackAlreadyExistException{

        when(trackRepository.save((Track) any())).thenReturn(track);
        Track savedTrack = trackService.saveTrack(track);
        assertEquals(track,savedTrack);
        verify(trackRepository,times(1)).save(track);

    }

    @Test(expected = TrackAlreadyExistException.class)
    public void saveTrackTestFailure() throws TrackAlreadyExistException {
        when(trackRepository.save((Track)any())).thenReturn(null);
        Track saveTrack = trackService.saveTrack(track);
        System.out.println("savedUser" + saveTrack);
        assertEquals(track,saveTrack);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/
    }

    @Test
    public void getAllTracks(){

        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> tracklist = trackService.getAllTracks();
        assertEquals(list,tracklist);
    }
    @Test
    public void deleteTrack()throws TrackNotFoundException {
        trackRepository.deleteById(track.getId());
        verify(trackRepository).deleteById(anyInt());
    }
    @Test
    public void updateTrackTest() throws TrackNotFoundException
    {
        when(trackRepository.save((Track)any())).thenReturn(track);
        Track updateTrack = null;
        try {
            updateTrack = trackService.saveTrack(track);
        } catch (TrackAlreadyExistException e) {
            e.printStackTrace();
        }
        assertEquals(track,updateTrack);
    }

}
