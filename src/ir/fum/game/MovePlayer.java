package ir.fum.game;

import ir.fum.gui.MapPanel;

import javax.swing.*;
import java.awt.*;

public class MovePlayer {


    private MapPanel panel;
    private Component c;
    private Player player;
    private GameBrain brain;

    public GameBrain getBrain() {
        return brain;
    }

    public void setBrain(GameBrain brain) {
        this.brain = brain;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Component getC() {
        return c;
    }

    public void setC(Component c) {
        this.c = c;
    }

    public MapPanel getPanel() {
        return panel;
    }

    public void setPanel(MapPanel panel) {
        this.panel = panel;
    }

    public MovePlayer(Component c, MapPanel panel, GameBrain Brain, int selectedRow, int selectedColumn, Player player) {
        setC(c);
        setPanel(panel);
        setPlayer(player);
        setBrain(Brain);

        if (getBrain().getCheckColumnMove()) {

            if (selectedRow - getPlayer().getPosition().getRowNumber() > 0) {

                for (int i = getPlayer().getPosition().getRowNumber(); i < selectedRow; i++) {
                    c = getPanel().getComponentAt(getPanel().getBlocks()[i + 1][selectedColumn].getX(), getPanel().getBlocks()[i + 1][selectedColumn].getY());
                    if (getPanel().getComponentAt(getPanel().getBlocks()[i + 1][selectedColumn].getX(), getPanel().getBlocks()[i + 1][selectedColumn].getY()) instanceof Apple) {
                        int score = ((Apple) getPanel().getComponentAt(getPanel().getBlocks()[i + 1][selectedColumn].getX(), getPanel().getBlocks()[i + 1][selectedColumn].getY())).score();
                        int power = ((Apple) getPanel().getComponentAt(getPanel().getBlocks()[i + 1][selectedColumn].getX(), getPanel().getBlocks()[i + 1][selectedColumn].getY())).power();
                        if (getPlayer() instanceof BluePlayer) {
                            movementBluePlayer(c, score, power, i + 1, selectedColumn);
                            getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower() - 1));
                        } else if (getPlayer() instanceof RedPlayer) {
                            movementRedPlayer(c, score, power, i + 1, selectedColumn);
                            getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower() - 1));
                        }


                    } else if (getPanel().getComponentAt(getPanel().getBlocks()[i + 1][selectedColumn].getX(), getPanel().getBlocks()[i + 1][selectedColumn].getY()) instanceof NormalBlock) {
                        int score = ((NormalBlock) getPanel().getComponentAt(getPanel().getBlocks()[i + 1][selectedColumn].getX(), getPanel().getBlocks()[i + 1][selectedColumn].getY())).score();
                        int power = ((NormalBlock) getPanel().getComponentAt(getPanel().getBlocks()[i + 1][selectedColumn].getX(), getPanel().getBlocks()[i + 1][selectedColumn].getY())).power();
                        if (getPlayer() instanceof BluePlayer) {
                            movementBluePlayer(c, score, power, i + 1, selectedColumn);
                        } else if (getPlayer() instanceof RedPlayer) {
                            movementRedPlayer(c, score, power, i + 1, selectedColumn);
                        }

                    } else if (getPanel().getComponentAt(getPanel().getBlocks()[i + 1][selectedColumn].getX(), getPanel().getBlocks()[i + 1][selectedColumn].getY()) instanceof Mushroom) {
                        int score = ((Mushroom) getPanel().getComponentAt(getPanel().getBlocks()[i + 1][selectedColumn].getX(), getPanel().getBlocks()[i + 1][selectedColumn].getY())).score();
                        int power = ((Mushroom) getPanel().getComponentAt(getPanel().getBlocks()[i + 1][selectedColumn].getX(), getPanel().getBlocks()[i + 1][selectedColumn].getY())).power();
                        if (getPlayer() instanceof BluePlayer) {
                            movementBluePlayer(c, score, power, i + 1, selectedColumn);
                            getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower()));
                        } else if (getPlayer() instanceof RedPlayer) {
                            movementRedPlayer(c, score, power, i + 1, selectedColumn);
                            getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower()));
                        }


                    } else if (getPanel().getComponentAt(getPanel().getBlocks()[i + 1][selectedColumn].getX(), getPanel().getBlocks()[i + 1][selectedColumn].getY()) instanceof Star) {
                        int score = ((Star) getPanel().getComponentAt(getPanel().getBlocks()[i + 1][selectedColumn].getX(), getPanel().getBlocks()[i + 1][selectedColumn].getY())).score();
                        int power = ((Star) getPanel().getComponentAt(getPanel().getBlocks()[i + 1][selectedColumn].getX(), getPanel().getBlocks()[i + 1][selectedColumn].getY())).power();
                        if (getPlayer() instanceof BluePlayer) {
                            movementBluePlayer(c, score, power, i + 1, selectedColumn);
                            getPanel().updateAvailableStars(-1);
                            getPanel().getBluePlayer().updateEatenStars(1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerStarNumber().setText(Integer.toString(getPanel().getBluePlayer().getEatenStars()));
                        } else if (getPlayer() instanceof RedPlayer) {
                            movementRedPlayer(c, score, power, i + 1, selectedColumn);
                            getPanel().updateAvailableStars(-1);
                            getPanel().getRedPlayer().updateEatenStars(1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerStarNumber().setText(Integer.toString(getPanel().getRedPlayer().getEatenStars()));
                        }


                    } else if (getPanel().getComponentAt(getPanel().getBlocks()[i + 1][selectedColumn].getX(), getPanel().getBlocks()[i + 1][selectedColumn].getY()) instanceof Player) {
                        c = getPanel().getComponentAt(getPanel().getBlocks()[i + 2][selectedColumn].getX(), getPanel().getBlocks()[i + 2][selectedColumn].getY());
                        if (c instanceof Apple) {
                            int score = ((Apple) c).score();
                            int power = ((Apple) c).power();
                            if (getPlayer() instanceof BluePlayer) {
                                jumpOverRedPlayer(c, i + 2, score, power, selectedColumn);
                                getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower() - 1));
                                ++i;

                            } else if (getPlayer() instanceof RedPlayer) {
                                jumpOverBluePlayer(c, i + 2, score, power, selectedColumn);
                                getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower() - 1));
                                ++i;

                            }

                        } else if (c instanceof NormalBlock) {
                            int score = ((NormalBlock) c).score();
                            int power = ((NormalBlock) c).power();
                            if (getPlayer() instanceof BluePlayer) {
                                jumpOverRedPlayer(c, i + 2, score, power, selectedColumn);
                                ++i;

                            } else if (getPlayer() instanceof RedPlayer) {
                                jumpOverBluePlayer(c, i + 2, score, power, selectedColumn);
                                ++i;

                            }
                        }


                    } else if (c instanceof Mushroom) {
                        int score = ((Mushroom) c).score();
                        int power = ((Mushroom) c).power();
                        if (getPlayer() instanceof BluePlayer) {
                            jumpOverRedPlayer(c, i + 2, score, power, selectedColumn);
                            getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower()));
                            ++i;

                        } else if (getPlayer() instanceof RedPlayer) {
                            jumpOverBluePlayer(c, i + 2, score, power, selectedColumn);
                            getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower()));
                            ++i;

                        }
                    } else if (c instanceof Star) {
                        int score = ((Star) c).score();
                        int power = ((Star) c).power();
                        if (getPlayer() instanceof BluePlayer) {
                            jumpOverRedPlayer(c, i + 2, score, power, selectedColumn);
                            getPanel().updateAvailableStars(-1);
                            getPanel().getBluePlayer().updateEatenStars(1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerStarNumber().setText(Integer.toString(getPanel().getBluePlayer().getEatenStars()));
                            ++i;

                        } else if (getPlayer() instanceof RedPlayer) {
                            jumpOverBluePlayer(c, i + 2, score, power, selectedColumn);
                            getPanel().updateAvailableStars(-1);
                            getPanel().getRedPlayer().updateEatenStars(1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerStarNumber().setText(Integer.toString(getPanel().getRedPlayer().getEatenStars()));
                            ++i;

                        }
                    }


                }
                if (checkAvailableStars()) {
                    arrangeMovingOrder();
                } else
                    disableAllButtons();
//                    getPanel().setSwitchPanel(3);


            } else if (selectedRow - getPlayer().getPosition().getRowNumber() < 0) {

                for (int i = getPlayer().getPosition().getRowNumber(); i > selectedRow; i--) {
                    c = getPanel().getComponentAt(getPanel().getBlocks()[i - 1][selectedColumn].getX(), getPanel().getBlocks()[i - 1][selectedColumn].getY());
                    if (getPanel().getComponentAt(getPanel().getBlocks()[i - 1][selectedColumn].getX(), getPanel().getBlocks()[i - 1][selectedColumn].getY()) instanceof Apple) {
                        int score = ((Apple) getPanel().getComponentAt(getPanel().getBlocks()[i - 1][selectedColumn].getX(), getPanel().getBlocks()[i - 1][selectedColumn].getY())).score();
                        int power = ((Apple) getPanel().getComponentAt(getPanel().getBlocks()[i - 1][selectedColumn].getX(), getPanel().getBlocks()[i - 1][selectedColumn].getY())).power();
                        if (getPlayer() instanceof BluePlayer) {
                            movementBluePlayer(c, score, power, i - 1, selectedColumn);
                            getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower() - 1));

                        } else if (getPlayer() instanceof RedPlayer) {
                            movementRedPlayer(c, score, power, i - 1, selectedColumn);
                            getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower() - 1));

                        }


                    } else if (getPanel().getComponentAt(getPanel().getBlocks()[i - 1][selectedColumn].getX(), getPanel().getBlocks()[i - 1][selectedColumn].getY()) instanceof NormalBlock) {
                        int score = ((NormalBlock) getPanel().getComponentAt(getPanel().getBlocks()[i - 1][selectedColumn].getX(), getPanel().getBlocks()[i - 1][selectedColumn].getY())).score();
                        int power = ((NormalBlock) getPanel().getComponentAt(getPanel().getBlocks()[i - 1][selectedColumn].getX(), getPanel().getBlocks()[i - 1][selectedColumn].getY())).power();
                        if (getPlayer() instanceof BluePlayer) {
                            movementBluePlayer(c, score, power, i - 1, selectedColumn);
                        } else if (getPlayer() instanceof RedPlayer) {
                            movementRedPlayer(c, score, power, i - 1, selectedColumn);
                        }

                    } else if (getPanel().getComponentAt(getPanel().getBlocks()[i - 1][selectedColumn].getX(), getPanel().getBlocks()[i - 1][selectedColumn].getY()) instanceof Mushroom) {
                        int score = ((Mushroom) getPanel().getComponentAt(getPanel().getBlocks()[i - 1][selectedColumn].getX(), getPanel().getBlocks()[i - 1][selectedColumn].getY())).score();
                        int power = ((Mushroom) getPanel().getComponentAt(getPanel().getBlocks()[i - 1][selectedColumn].getX(), getPanel().getBlocks()[i - 1][selectedColumn].getY())).power();
                        if (getPlayer() instanceof BluePlayer) {
                            movementBluePlayer(c, score, power, i - 1, selectedColumn);
                            getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower()));
                        } else if (getPlayer() instanceof RedPlayer) {
                            movementRedPlayer(c, score, power, i - 1, selectedColumn);
                            getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower()));
                        }


                    } else if (getPanel().getComponentAt(getPanel().getBlocks()[i - 1][selectedColumn].getX(), getPanel().getBlocks()[i - 1][selectedColumn].getY()) instanceof Star) {
                        int score = ((Star) getPanel().getComponentAt(getPanel().getBlocks()[i - 1][selectedColumn].getX(), getPanel().getBlocks()[i - 1][selectedColumn].getY())).score();
                        int power = ((Star) getPanel().getComponentAt(getPanel().getBlocks()[i - 1][selectedColumn].getX(), getPanel().getBlocks()[i - 1][selectedColumn].getY())).power();
                        if (getPlayer() instanceof BluePlayer) {
                            movementBluePlayer(c, score, power, i - 1, selectedColumn);
                            getPanel().updateAvailableStars(-1);
                            getPanel().getBluePlayer().updateEatenStars(1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerStarNumber().setText(Integer.toString(getPanel().getBluePlayer().getEatenStars()));

                        } else if (getPlayer() instanceof RedPlayer) {
                            movementRedPlayer(c, score, power, i - 1, selectedColumn);
                            getPanel().updateAvailableStars(-1);
                            getPanel().getRedPlayer().updateEatenStars(1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerStarNumber().setText(Integer.toString(getPanel().getRedPlayer().getEatenStars()));

                        }


                    } else if (getPanel().getComponentAt(getPanel().getBlocks()[i - 1][selectedColumn].getX(), getPanel().getBlocks()[i - 1][selectedColumn].getY()) instanceof Player) {
                        c = getPanel().getComponentAt(getPanel().getBlocks()[i - 2][selectedColumn].getX(), getPanel().getBlocks()[i - 2][selectedColumn].getY());
                        if (c instanceof Apple) {
                            int score = ((Apple) c).score();
                            int power = ((Apple) c).power();

                            if (getPlayer() instanceof BluePlayer) {
                                jumpOverRedPlayer(c, i - 2, score, power, selectedColumn);
                                getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower() - 1));

                                --i;

                            } else if (getPlayer() instanceof RedPlayer) {
                                jumpOverBluePlayer(c, i - 2, score, power, selectedColumn);
                                getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower() - 1));

                                --i;

                            }
                        } else if (c instanceof NormalBlock) {
                            int score = ((NormalBlock) c).score();
                            int power = ((NormalBlock) c).power();

                            if (getPlayer() instanceof BluePlayer) {
                                jumpOverRedPlayer(c, i - 2, score, power, selectedColumn);
                                --i;

                            } else if (getPlayer() instanceof RedPlayer) {
                                jumpOverBluePlayer(c, i - 2, score, power, selectedColumn);
                                --i;

                            }
                        } else if (c instanceof Mushroom) {
                            int score = ((Mushroom) c).score();
                            int power = ((Mushroom) c).power();

                            if (getPlayer() instanceof BluePlayer) {
                                jumpOverRedPlayer(c, i - 2, score, power, selectedColumn);
                                getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower()));
                                --i;

                            } else if (getPlayer() instanceof RedPlayer) {
                                jumpOverBluePlayer(c, i - 2, score, power, selectedColumn);
                                getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower()));
                                --i;

                            }
                        } else if (c instanceof Star) {
                            int score = ((Star) c).score();
                            int power = ((Star) c).power();

                            if (getPlayer() instanceof BluePlayer) {
                                jumpOverRedPlayer(c, i - 2, score, power, selectedColumn);
                                getPanel().updateAvailableStars(-1);
                                getPanel().getBluePlayer().updateEatenStars(1);
                                getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerStarNumber().setText(Integer.toString(getPanel().getBluePlayer().getEatenStars()));

                                --i;

                            } else if (getPlayer() instanceof RedPlayer) {
                                jumpOverBluePlayer(c, i - 2, score, power, selectedColumn);
                                getPanel().updateAvailableStars(-1);
                                getPanel().getRedPlayer().updateEatenStars(1);
                                getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerStarNumber().setText(Integer.toString(getPanel().getRedPlayer().getEatenStars()));

                                --i;

                            }
                        }


                    }


                }
                if (checkAvailableStars()) {
                    arrangeMovingOrder();
                } else
                    disableAllButtons();
//                    getPanel().setSwitchPanel(3);
            }


        } else if (getBrain().getCheckRowMove()) {


            if (selectedColumn - getPlayer().getPosition().getColumnNumber() > 0) {

                for (int j = getPlayer().getPosition().getColumnNumber(); j < selectedColumn; j++) {
                    c = getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j + 1].getX(), getPanel().getBlocks()[selectedRow][j + 1].getY());
                    if (getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j + 1].getX(), getPanel().getBlocks()[selectedRow][j + 1].getY()) instanceof Apple) {
                        int score = ((Apple) getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j + 1].getX(), getPanel().getBlocks()[selectedRow][j + 1].getY())).score();
                        int power = ((Apple) getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j + 1].getX(), getPanel().getBlocks()[selectedRow][j + 1].getY())).power();
                        if (getPlayer() instanceof BluePlayer) {
                            movementBluePlayer(c, score, power, selectedRow, j + 1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower() - 1));
                        } else if (getPlayer() instanceof RedPlayer) {
                            movementRedPlayer(c, score, power, selectedRow, j + 1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower() - 1));
                        }


                    } else if (getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j + 1].getX(), getPanel().getBlocks()[selectedRow][j + 1].getY()) instanceof NormalBlock) {
                        int score = ((NormalBlock) getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j + 1].getX(), getPanel().getBlocks()[selectedRow][j + 1].getY())).score();
                        int power = ((NormalBlock) getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j + 1].getX(), getPanel().getBlocks()[selectedRow][j + 1].getY())).power();
                        if (getPlayer() instanceof BluePlayer) {
                            movementBluePlayer(c, score, power, selectedRow, j + 1);
                        } else if (getPlayer() instanceof RedPlayer) {
                            movementRedPlayer(c, score, power, selectedRow, j + 1);
                        }

                    } else if (getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j + 1].getX(), getPanel().getBlocks()[selectedRow][j + 1].getY()) instanceof Mushroom) {
                        int score = ((Mushroom) getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j + 1].getX(), getPanel().getBlocks()[selectedRow][j + 1].getY())).score();
                        int power = ((Mushroom) getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j + 1].getX(), getPanel().getBlocks()[selectedRow][j + 1].getY())).power();
                        if (getPlayer() instanceof BluePlayer) {
                            movementBluePlayer(c, score, power, selectedRow, j + 1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower()));
                        } else if (getPlayer() instanceof RedPlayer) {
                            movementRedPlayer(c, score, power, selectedRow, j + 1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower()));
                        }


                    } else if (getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j + 1].getX(), getPanel().getBlocks()[selectedRow][j + 1].getY()) instanceof Star) {
                        int score = ((Star) getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j + 1].getX(), getPanel().getBlocks()[selectedRow][j + 1].getY())).score();
                        int power = ((Star) getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j + 1].getX(), getPanel().getBlocks()[selectedRow][j + 1].getY())).power();
                        if (getPlayer() instanceof BluePlayer) {
                            movementBluePlayer(c, score, power, selectedRow, j + 1);
                            getPanel().updateAvailableStars(-1);
                            getPanel().getBluePlayer().updateEatenStars(1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerStarNumber().setText(Integer.toString(getPanel().getBluePlayer().getEatenStars()));
                        } else if (getPlayer() instanceof RedPlayer) {
                            movementRedPlayer(c, score, power, selectedRow, j + 1);
                            getPanel().updateAvailableStars(-1);
                            getPanel().getRedPlayer().updateEatenStars(1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerStarNumber().setText(Integer.toString(getPanel().getRedPlayer().getEatenStars()));
                        }


                    } else if (getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j + 1].getX(), getPanel().getBlocks()[selectedRow][j + 1].getY()) instanceof Player) {
                        c = getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j + 2].getX(), getPanel().getBlocks()[selectedRow][j + 2].getY());
                        if (c instanceof Apple) {
                            int score = ((Apple) c).score();
                            int power = ((Apple) c).power();
                            if (getPlayer() instanceof BluePlayer) {
                                jumpOverRedPlayer(c, selectedRow, score, power, j + 2);
                                getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower() - 1));
                                ++j;

                            } else if (getPlayer() instanceof RedPlayer) {
                                jumpOverBluePlayer(c, selectedRow, score, power, j + 2);
                                getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower() - 1));
                                ++j;

                            }

                        } else if (c instanceof NormalBlock) {
                            int score = ((NormalBlock) c).score();
                            int power = ((NormalBlock) c).power();
                            if (getPlayer() instanceof BluePlayer) {
                                jumpOverRedPlayer(c, selectedRow, score, power, j + 2);
                                ++j;

                            } else if (getPlayer() instanceof RedPlayer) {
                                jumpOverBluePlayer(c, selectedRow, score, power, j + 2);
                                ++j;

                            }
                        }


                    } else if (c instanceof Mushroom) {
                        int score = ((Mushroom) c).score();
                        int power = ((Mushroom) c).power();
                        if (getPlayer() instanceof BluePlayer) {
                            jumpOverRedPlayer(c, selectedRow, score, power, j + 2);
                            getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower()));
                            ++j;

                        } else if (getPlayer() instanceof RedPlayer) {
                            jumpOverBluePlayer(c, selectedRow, score, power, j + 2);
                            getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower()));
                            ++j;

                        }
                    } else if (c instanceof Star) {
                        int score = ((Star) c).score();
                        int power = ((Star) c).power();
                        if (getPlayer() instanceof BluePlayer) {
                            jumpOverRedPlayer(c, selectedRow, score, power, j + 2);
                            getPanel().updateAvailableStars(-1);
                            getPanel().getBluePlayer().updateEatenStars(1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerStarNumber().setText(Integer.toString(getPanel().getBluePlayer().getEatenStars()));
                            ++j;

                        } else if (getPlayer() instanceof RedPlayer) {
                            jumpOverBluePlayer(c, selectedRow, score, power, j + 2);
                            getPanel().updateAvailableStars(-1);
                            getPanel().getRedPlayer().updateEatenStars(1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerStarNumber().setText(Integer.toString(getPanel().getRedPlayer().getEatenStars()));
                            ++j;

                        }
                    }


                }
                if (checkAvailableStars()) {
                    arrangeMovingOrder();
                } else
                    disableAllButtons();
//                    getPanel().setSwitchPanel(3);


            }
            if (selectedColumn - getPlayer().getPosition().getColumnNumber() < 0) {

                for (int j = getPlayer().getPosition().getColumnNumber(); j > selectedColumn; j--) {
                    c = getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j - 1].getX(), getPanel().getBlocks()[selectedRow][j - 1].getY());
                    if (getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j - 1].getX(), getPanel().getBlocks()[selectedRow][j - 1].getY()) instanceof Apple) {
                        int score = ((Apple) getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j - 1].getX(), getPanel().getBlocks()[selectedRow][j - 1].getY())).score();
                        int power = ((Apple) getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j - 1].getX(), getPanel().getBlocks()[selectedRow][j - 1].getY())).power();
                        if (getPlayer() instanceof BluePlayer) {
                            movementBluePlayer(c, score, power, selectedRow, j - 1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower() - 1));
                        } else if (getPlayer() instanceof RedPlayer) {
                            movementRedPlayer(c, score, power, selectedRow, j - 1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower() - 1));
                        }


                    } else if (getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j - 1].getX(), getPanel().getBlocks()[selectedRow][j - 1].getY()) instanceof NormalBlock) {
                        int score = ((NormalBlock) getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j - 1].getX(), getPanel().getBlocks()[selectedRow][j - 1].getY())).score();
                        int power = ((NormalBlock) getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j - 1].getX(), getPanel().getBlocks()[selectedRow][j - 1].getY())).power();
                        if (getPlayer() instanceof BluePlayer) {
                            movementBluePlayer(c, score, power, selectedRow, j - 1);
                        } else if (getPlayer() instanceof RedPlayer) {
                            movementRedPlayer(c, score, power, selectedRow, j - 1);
                        }

                    } else if (getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j - 1].getX(), getPanel().getBlocks()[selectedRow][j - 1].getY()) instanceof Mushroom) {
                        int score = ((Mushroom) getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j - 1].getX(), getPanel().getBlocks()[selectedRow][j - 1].getY())).score();
                        int power = ((Mushroom) getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j - 1].getX(), getPanel().getBlocks()[selectedRow][j - 1].getY())).power();
                        if (getPlayer() instanceof BluePlayer) {
                            movementBluePlayer(c, score, power, selectedRow, j - 1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower()));
                        } else if (getPlayer() instanceof RedPlayer) {
                            movementRedPlayer(c, score, power, selectedRow, j - 1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower()));
                        }


                    } else if (getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j - 1].getX(), getPanel().getBlocks()[selectedRow][j - 1].getY()) instanceof Star) {
                        int score = ((Star) getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j - 1].getX(), getPanel().getBlocks()[selectedRow][j - 1].getY())).score();
                        int power = ((Star) getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j - 1].getX(), getPanel().getBlocks()[selectedRow][j - 1].getY())).power();
                        if (getPlayer() instanceof BluePlayer) {
                            movementBluePlayer(c, score, power, selectedRow, j - 1);
                            getPanel().updateAvailableStars(-1);
                            getPanel().getBluePlayer().updateEatenStars(1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerStarNumber().setText(Integer.toString(getPanel().getBluePlayer().getEatenStars()));
                        } else if (getPlayer() instanceof RedPlayer) {
                            movementRedPlayer(c, score, power, selectedRow, j - 1);
                            getPanel().updateAvailableStars(-1);
                            getPanel().getRedPlayer().updateEatenStars(1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerStarNumber().setText(Integer.toString(getPanel().getRedPlayer().getEatenStars()));
                        }


                    } else if (getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j - 1].getX(), getPanel().getBlocks()[selectedRow][j - 1].getY()) instanceof Player) {
                        c = getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j - 2].getX(), getPanel().getBlocks()[selectedRow][j - 2].getY());
                        if (c instanceof Apple) {
                            int score = ((Apple) c).score();
                            int power = ((Apple) c).power();
                            if (getPlayer() instanceof BluePlayer) {
                                jumpOverRedPlayer(c, selectedRow, score, power, j - 2);
                                getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower() - 1));
                                --j;

                            } else if (getPlayer() instanceof RedPlayer) {
                                jumpOverBluePlayer(c, selectedRow, score, power, j - 2);
                                getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower() - 1));
                                --j;

                            }

                        } else if (c instanceof NormalBlock) {
                            int score = ((NormalBlock) c).score();
                            int power = ((NormalBlock) c).power();
                            if (getPlayer() instanceof BluePlayer) {
                                jumpOverRedPlayer(c, selectedRow, score, power, j - 2);
                                --j;

                            } else if (getPlayer() instanceof RedPlayer) {
                                jumpOverBluePlayer(c, selectedRow, score, power, j - 2);
                                --j;

                            }
                        }


                    } else if (c instanceof Mushroom) {
                        int score = ((Mushroom) c).score();
                        int power = ((Mushroom) c).power();
                        if (getPlayer() instanceof BluePlayer) {
                            jumpOverRedPlayer(c, selectedRow, score, power, j - 2);
                            getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower()));
                            --j;

                        } else if (getPlayer() instanceof RedPlayer) {
                            jumpOverBluePlayer(c, selectedRow, score, power, j - 2);
                            getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower()));
                            --j;

                        }
                    } else if (c instanceof Star) {
                        int score = ((Star) c).score();
                        int power = ((Star) c).power();
                        if (getPlayer() instanceof BluePlayer) {
                            jumpOverRedPlayer(c, selectedRow, score, power, j - 2);
                            getPanel().updateAvailableStars(-1);
                            getPanel().getBluePlayer().updateEatenStars(1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerStarNumber().setText(Integer.toString(getPanel().getBluePlayer().getEatenStars()));
                            --j;

                        } else if (getPlayer() instanceof RedPlayer) {
                            jumpOverBluePlayer(c, selectedRow, score, power, j - 2);
                            getPanel().updateAvailableStars(-1);
                            getPanel().getRedPlayer().updateEatenStars(1);
                            getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerStarNumber().setText(Integer.toString(getPanel().getRedPlayer().getEatenStars()));
                            --j;

                        }
                    }


                }
                if (checkAvailableStars()) {
                    arrangeMovingOrder();
                } else
                    disableAllButtons();
//                    getPanel().setSwitchPanel(3);


            }


        }
    }

    public void disableAllButtons() {
        for (int i = 0; i < getPanel().getInitializeMapButton().getNRow(); i++) {
            for (int j = 0; j < getPanel().getInitializeMapButton().getNColumn(); j++) {

                getPanel().getComponentAt(getPanel().getBlocks()[i][j].getX(), getPanel().getBlocks()[i][j].getY()).setEnabled(false);
//                getPanel().getWestPanel().getFrame().getScorePanel().setEnabled(false);


            }


        }


    }


    public void movementBluePlayer(Component c, int score, int power, int Row, int Column) {
        int componentPosition = getPanel().getComponentZOrder(c);
        getPanel().remove(getPanel().getComponent(componentPosition));
        int lastBluePlayerPosition = getPanel().getBluePlayer().getPlayerComponentBlock();
        int lastRowBluePlayerPosition = getPanel().getBluePlayer().getPosition().getRowNumber();
        int lastColumnBluePlayerPosition = getPanel().getBluePlayer().getPosition().getColumnNumber();

        getPanel().add(new BluePlayer(Row, Column, score, power, componentPosition, getPanel()), componentPosition);
        getPanel().remove(getPanel().getComponent(lastBluePlayerPosition));
        System.out.println(getPanel().getBluePlayer().getPower());
        NormalBlock normalBlock = new NormalBlock(lastRowBluePlayerPosition, lastColumnBluePlayerPosition);
        normalBlock.addActionListener(new BtnListenerToMovePlayer(lastRowBluePlayerPosition, lastColumnBluePlayerPosition, getPanel()));
        getPanel().add(normalBlock, lastBluePlayerPosition);

        getPanel().getWestPanel().add(getPanel(), BorderLayout.NORTH);
        getPanel().getWestPanel().getFrame().add(getPanel().getWestPanel(), BorderLayout.WEST);
        getPanel().getWestPanel().getFrame().setVisible(true);


    }


    public void movementRedPlayer(Component c, int score, int power, int Row, int Column) {

        int componentPosition = getPanel().getComponentZOrder(c);
        getPanel().remove(getPanel().getComponent(componentPosition));
        int lastRedPlayerPosition = getPanel().getRedPlayer().getPlayerComponentBlock();
        int lastRowRedPlayerPosition = getPanel().getRedPlayer().getPosition().getRowNumber();
        int lastColumnRedPlayerPosition = getPanel().getRedPlayer().getPosition().getColumnNumber();

        getPanel().add(new RedPlayer(Row, Column, score, power, componentPosition, getPanel()), componentPosition);
        getPanel().remove(getPanel().getComponent(lastRedPlayerPosition));
        System.out.println(getPanel().getRedPlayer().getPower());
//        getPanel().add(new Apple(lastRowRedPlayerPosition, lastColumnRedPlayerPosition), lastRedPlayerPosition);
        NormalBlock normalBlock = new NormalBlock(lastRowRedPlayerPosition, lastColumnRedPlayerPosition);
        normalBlock.addActionListener(new BtnListenerToMovePlayer(lastRowRedPlayerPosition, lastColumnRedPlayerPosition, getPanel()));
        getPanel().add(normalBlock, lastRedPlayerPosition);

        getPanel().getWestPanel().add(getPanel(), BorderLayout.NORTH);
        getPanel().getWestPanel().getFrame().add(getPanel().getWestPanel(), BorderLayout.WEST);
        getPanel().getWestPanel().getFrame().setVisible(true);


    }

    public void jumpOverBluePlayer(Component c, int Row, int score, int power, int Column) {
        int componentPosition = getPanel().getComponentZOrder(c);
        getPanel().remove(getPanel().getComponent(componentPosition));
        int lastRedPlayerPosition = getPanel().getRedPlayer().getPlayerComponentBlock();
        int lastRowRedPlayerPosition = getPanel().getRedPlayer().getPosition().getRowNumber();
        int lastColumnRedPlayerPosition = getPanel().getRedPlayer().getPosition().getColumnNumber();

        getPanel().add(new RedPlayer(Row, Column, score, power, componentPosition, getPanel()), componentPosition);
        getPanel().remove(getPanel().getComponent(lastRedPlayerPosition));
        System.out.println(getPanel().getRedPlayer().getPower());
//        getPanel().add(new Apple(lastRowRedPlayerPosition, lastColumnRedPlayerPosition), lastRedPlayerPosition);
        NormalBlock normalBlock = new NormalBlock(lastRowRedPlayerPosition, lastColumnRedPlayerPosition);
        normalBlock.addActionListener(new BtnListenerToMovePlayer(lastRowRedPlayerPosition, lastColumnRedPlayerPosition, getPanel()));
        getPanel().add(normalBlock, lastRedPlayerPosition);

        getPanel().getWestPanel().add(getPanel(), BorderLayout.NORTH);
        getPanel().getWestPanel().getFrame().add(getPanel().getWestPanel(), BorderLayout.WEST);
        getPanel().getWestPanel().getFrame().setVisible(true);

    }

    public void jumpOverRedPlayer(Component c, int Row, int score, int power, int Column) {
        int componentPosition = getPanel().getComponentZOrder(c);
        getPanel().remove(getPanel().getComponent(componentPosition));
        int lastBluePlayerPosition = getPanel().getBluePlayer().getPlayerComponentBlock();
        int lastRowBluePlayerPosition = getPanel().getBluePlayer().getPosition().getRowNumber();
        int lastColumnBluePlayerPosition = getPanel().getBluePlayer().getPosition().getColumnNumber();

        getPanel().add(new BluePlayer(Row, Column, score, power, componentPosition, getPanel()), componentPosition);
        getPanel().remove(getPanel().getComponent(lastBluePlayerPosition));
        System.out.println(getPanel().getBluePlayer().getPower());
        NormalBlock normalBlock = new NormalBlock(lastRowBluePlayerPosition, lastColumnBluePlayerPosition);
        normalBlock.addActionListener(new BtnListenerToMovePlayer(lastRowBluePlayerPosition, lastColumnBluePlayerPosition, getPanel()));
        getPanel().add(normalBlock, lastBluePlayerPosition);

        getPanel().getWestPanel().add(getPanel(), BorderLayout.NORTH);
        getPanel().getWestPanel().getFrame().add(getPanel().getWestPanel(), BorderLayout.WEST);
        getPanel().getWestPanel().getFrame().setVisible(true);

    }

    public void arrangeMovingOrder() {
        if (getPlayer() instanceof BluePlayer) {
            if (getPanel().getRedPlayer().getPower() > 0) {
                getPanel().setSwitchPanel(getPanel().getSwitchPanel() + 1);
//                System.out.println("Red Player");
                getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerOrder().setBackground(Color.RED);
                getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerOrder().setBackground(Color.GREEN);
            } else if (getPanel().getRedPlayer().getPower() == 0 && getPanel().getBluePlayer().getPower() == 0) {
                getPanel().setSwitchPanel(1);
                getPanel().getRedPlayer().setPower(1);
                getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower() - 1));
                getPanel().getBluePlayer().setPower(1);
                getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower() - 1));
//                System.out.println("Red Player");
                getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerOrder().setBackground(Color.GREEN);
                getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerOrder().setBackground(Color.RED);
            } else {
                getPanel().setSwitchPanel(getPanel().getSwitchPanel());
                getPanel().getRedPlayer().setPower(1);
                getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower() - 1));

//                System.out.println("Blue Player Again");
                getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerOrder().setBackground(Color.GREEN);
                getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerOrder().setBackground(Color.RED);
            }
        } else if (getPlayer() instanceof RedPlayer) {
            if (getPanel().getBluePlayer().getPower() > 0) {
                getPanel().setSwitchPanel(getPanel().getSwitchPanel() - 1);
//                System.out.println("Blue Player ");
                getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerOrder().setBackground(Color.GREEN);
                getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerOrder().setBackground(Color.RED);
            } else if (getPanel().getRedPlayer().getPower() == 0 && getPanel().getBluePlayer().getPower() == 0) {

                getPanel().setSwitchPanel(0);
                getPanel().getRedPlayer().setPower(1);
                getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerAppleNumber().setText(Integer.toString(getPanel().getRedPlayer().getPower() - 1));
                getPanel().getBluePlayer().setPower(1);
                getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower() - 1));
//                System.out.println("Blue Player");
                getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerOrder().setBackground(Color.GREEN);
                getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerOrder().setBackground(Color.RED);


            } else {
                getPanel().setSwitchPanel(getPanel().getSwitchPanel());
                getPanel().getBluePlayer().setPower(1);
                getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerAppleNumber().setText(Integer.toString(getPanel().getBluePlayer().getPower() - 1));
//                System.out.println("Red Player Again");
                getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerOrder().setBackground(Color.RED);
                getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerOrder().setBackground(Color.GREEN);
            }
        }


    }

    public Boolean checkAvailableStars() {
        Boolean continueGame = false;
        if (getPanel().getAvailableStars() == 0) {
            continueGame = false;
            if (getPanel().getBluePlayer().getEatenStars() > getPanel().getRedPlayer().getEatenStars()) {


                showWinnerMessageForBluePlayer();
//                System.out.println("Winner is Blue Player");

            } else if (getPanel().getBluePlayer().getEatenStars() < getPanel().getRedPlayer().getEatenStars()) {
//                System.out.println("Winner is Red Player");
                showWinnerMessageForRedPlayer();
            } else if (getPanel().getBluePlayer().getEatenStars() == getPanel().getRedPlayer().getEatenStars()) {

                if (getPanel().getBluePlayer().getPower() > getPanel().getRedPlayer().getPower()) {
//                    System.out.println("Winner is Blue Player");
                    showWinnerMessageForBluePlayer();
                } else
//                    System.out.println("Winner is Red Player");
                    showWinnerMessageForRedPlayer();

            }


        } else
            continueGame = true;
        return continueGame;


    }

    public void showWinnerMessageForBluePlayer() {


        JOptionPane.showMessageDialog(null, "Blue Player is the winner "
                , "Ending Game", JOptionPane.INFORMATION_MESSAGE, new Pictures().bluePlayerImage);


    }

    public void showWinnerMessageForRedPlayer() {

        JOptionPane.showMessageDialog(null, "Red Player is the winner "
                , "Ending Game", JOptionPane.INFORMATION_MESSAGE, new Pictures().redPlayerImage);


    }


}
